package com.linkedin.datahub.graphql.types.corpuser.mappers;

import com.linkedin.datahub.graphql.QueryContext;
import com.linkedin.datahub.graphql.generated.CorpUser;
import com.linkedin.datahub.graphql.generated.CorpUserProperties;
import com.linkedin.datahub.graphql.types.mappers.ModelMapper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Maps Pegasus {@link RecordTemplate} objects to objects conforming to the GQL schema. */
public class CorpUserPropertiesMapper
    implements ModelMapper<com.linkedin.identity.CorpUserInfo, CorpUserProperties> {

  public static final CorpUserPropertiesMapper INSTANCE = new CorpUserPropertiesMapper();

  public static CorpUserProperties map(
      @Nullable QueryContext context,
      @Nonnull final com.linkedin.identity.CorpUserInfo corpUserInfo) {
    return INSTANCE.apply(context, corpUserInfo);
  }

  @Override
  public CorpUserProperties apply(
      @Nullable QueryContext context, @Nonnull final com.linkedin.identity.CorpUserInfo info) {
    final CorpUserProperties result = new CorpUserProperties();
    result.setActive(info.isActive());
    result.setCountryCode(info.getCountryCode());
    result.setDepartmentId(info.getDepartmentId());
    result.setDepartmentName(info.getDepartmentName());
    result.setEmail(info.getEmail());
    result.setDisplayName(info.getDisplayName());
    result.setFirstName(info.getFirstName());
    result.setLastName(info.getLastName());
    result.setFullName(info.getFullName());
    result.setTitle(info.getTitle());
    if (info.hasManagerUrn()) {
      result.setManager(new CorpUser.Builder().setUrn(info.getManagerUrn().toString()).build());
    }
    return result;
  }
}
